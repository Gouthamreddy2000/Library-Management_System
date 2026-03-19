package com.goutham.LMS.controller;

import com.goutham.LMS.dao.BorrowBookRepository;
import com.goutham.LMS.entity.Book;
import com.goutham.LMS.entity.BorrowBook;
import com.goutham.LMS.entity.User;
import com.goutham.LMS.service.BookService;
import com.goutham.LMS.service.BorrowBookService;
import com.goutham.LMS.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class AuthController {
    private UserService userService;
    private BookService bookService;
    private BorrowBookService borrowBookService;
    private BorrowBookRepository borrowBookRepository;
    public AuthController(UserService theUserService, BookService theBookService, BorrowBookService theBorrowBookService, BorrowBookRepository theBorrowBookRepository){
        userService=theUserService;
        bookService=theBookService;
        borrowBookService=theBorrowBookService;
        borrowBookRepository=theBorrowBookRepository;
    }
    @GetMapping("/")
    public String myHome(Model theModel, Authentication authentication){
        List<Book> theBooks=bookService.findAll();
        String userName=authentication.getName();
        theModel.addAttribute("books",theBooks);
        theModel.addAttribute("currentUser", userName);
        return "home";
    }
    @GetMapping("/showMyLoginPage")
    public String getLoginPage(){
        return "login";
    }
    @GetMapping("/showFormForAdd")
    public String add(Model model){
        model.addAttribute("book", new Book());
        return "book-form";

    }
    @GetMapping("/showRegistrationPage")
    public String registrationPage(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("bookId") int theId,Model theModel){
        Book theBook=bookService.findById(theId);
        theModel.addAttribute("book",theBook);
        return "book-form";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("bookId") int theId){
        bookService.deleteById(theId);
        return "redirect:/";
    }
    @PostMapping("/users/save")
    public String save(@ModelAttribute("user") User theUser){
        userService.save(theUser);
        return "redirect:/showMyLoginPage";
    }
    @PostMapping("/books/save")
    public String saveBooks(@ModelAttribute("book") Book theBook){
        bookService.save(theBook);
        return "redirect:/";
    }
    @GetMapping("/books/search")
    public String searchBooks(@RequestParam("keyword") String theKeyword, Model theModel){
        List<Book> theBooks=bookService.search(theKeyword);
        theModel.addAttribute("books",theBooks);
        return "home";
    }

    @GetMapping("/showFormForBorrow")
    public String showFormForBorrow(@RequestParam("bookId") int theId, Authentication authentication){
        BorrowBook theBorrowBook=new BorrowBook();
        String email=authentication.getName();
        User user=userService.findByEmail(email);
        int userId=user.getUser_id();
        theBorrowBook.setBookId(theId);
        theBorrowBook.setUserId(userId);
        theBorrowBook.setBorrowed_date(LocalDateTime.now());
        theBorrowBook.setStatus(BorrowBook.BorrowStatus.BORROWED);
        Book theBook=bookService.findById(theId);
        theBook.setAvailableCopies(theBook.getAvailableCopies()-1);
        borrowBookService.save(theBorrowBook);
        System.out.println(theBorrowBook);
        return "redirect:/";
    }

    @GetMapping("/showFormForReturn")
    public String showFormForReturn(@RequestParam("bookId") int theId, Authentication authentication){
        String email = authentication.getName();
        User user = userService.findByEmail(email);

        borrowBookService.returnBook(user.getUser_id(), theId);

        return "redirect:/";
    }
}
