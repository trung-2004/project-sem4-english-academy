package com.englishacademy.EnglishAcademy.controllers;

import com.englishacademy.EnglishAcademy.dtos.ResponseObject;
import com.englishacademy.EnglishAcademy.dtos.auth.JwtAuthenticationResponse;
import com.englishacademy.EnglishAcademy.dtos.student.StudentDTO;
import com.englishacademy.EnglishAcademy.dtos.user.UserDTO;
import com.englishacademy.EnglishAcademy.entities.Student;
import com.englishacademy.EnglishAcademy.entities.User;
import com.englishacademy.EnglishAcademy.exceptions.AppException;
import com.englishacademy.EnglishAcademy.exceptions.ErrorCode;
import com.englishacademy.EnglishAcademy.models.auth.*;
import com.englishacademy.EnglishAcademy.services.IAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthenticationController {
    private final IAuthenticationService authenticationService;

    @PostMapping("/auth/user/signup")
    public ResponseEntity<User> signup(@RequestBody SignUpRequest signUpRequest) {
        return ResponseEntity.ok(authenticationService.signup(signUpRequest));
    }
    @PostMapping("/auth/user/signip")
    public ResponseEntity<JwtAuthenticationResponse> signip(@RequestBody SignInRequest signInRequest) {
            return ResponseEntity.ok(authenticationService.signin(signInRequest));
    }
    @PostMapping("/auth/user/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
    }

    @PostMapping("/auth/student/signup")
    public ResponseEntity<Student> studentSignup(@RequestBody SignUpRequest signUpRequest) {
        return ResponseEntity.ok(authenticationService.studentSignUp(signUpRequest));
    }

    @PostMapping("/auth/student/signip")
    public ResponseEntity<JwtAuthenticationResponse> studentSignip(@RequestBody SignInRequest signInRequest) {
        return ResponseEntity.ok(authenticationService.studentSignIn(signInRequest));
    }

    @GetMapping("/user/profile")
    ResponseEntity<ResponseObject> profile() {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        if (!(auth.getPrincipal() instanceof User)) {
            throw new AppException(ErrorCode.NOTFOUND);
        }
        if (auth == null) throw new AppException(ErrorCode.UNAUTHENTICATED);
        User currentUser = (User) auth.getPrincipal();
        UserDTO userDTO = authenticationService.profile(currentUser);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(true, 200, "ok", userDTO)
        );
    }

    @GetMapping("/student/profile")
    ResponseEntity<ResponseObject> studentProfile() {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        if (!(auth.getPrincipal() instanceof Student)) {
            throw new AppException(ErrorCode.NOTFOUND);
        }
        if (auth == null) throw new AppException(ErrorCode.UNAUTHENTICATED);
        Student currentStudent = (Student) auth.getPrincipal();
        StudentDTO studentDTO = authenticationService.studentProfile(currentStudent);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(true, 200, "ok", studentDTO)
        );
    }

    @PostMapping("/user/change-password")
    public ResponseEntity<ResponseObject> changepassword(@RequestBody ChangePasswordRequest changePasswordRequest) {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        if (!(auth.getPrincipal() instanceof User)) {
            throw new AppException(ErrorCode.NOTFOUND);
        }
        if (auth == null) throw new AppException(ErrorCode.UNAUTHENTICATED);
        User currentUser = (User) auth.getPrincipal();
        authenticationService.changePassword(changePasswordRequest, currentUser);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(true, 200, "ok", "")
        );
    }

    @PostMapping("/student/change-password")
    public ResponseEntity<ResponseObject> studenrChangepassword(@RequestBody ChangePasswordRequest changePasswordRequest) {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        if (!(auth.getPrincipal() instanceof Student)) {
            throw new AppException(ErrorCode.NOTFOUND);
        }
        if (auth == null) throw new AppException(ErrorCode.UNAUTHENTICATED);
        Student currentStudent = (Student) auth.getPrincipal();
        authenticationService.studentChangePassword(changePasswordRequest, currentStudent);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(true, 200, "ok", "")
        );
    }

    @PostMapping("/auth/user/forgot-password")
    public ResponseEntity<ResponseObject> forgotPassword(@RequestBody ForgotPasswordRequest forgotPasswordRequest) {
        authenticationService.forgotPassword(forgotPasswordRequest);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(true, 200, "ok", "")
        );
    }

    @PostMapping("/auth/user/reset-password/{token}")
    public ResponseEntity<ResponseObject> resetPassword(
            @PathVariable("token") String token,
            @RequestBody ResetPasswordRequest resetPasswordRequest
    ) {
        authenticationService.resetPassword(resetPasswordRequest, token);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(true, 200, "ok", "")
        );
    }

    @PostMapping("/auth/student/forgot-password")
    public ResponseEntity<ResponseObject> studentForgotPassword(@RequestBody ForgotPasswordRequest forgotPasswordRequest) {
        authenticationService.studentForgotPassword(forgotPasswordRequest);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(true, 200, "ok", "")
        );
    }

    @PostMapping("/auth/student/reset-password/{token}")
    public ResponseEntity<ResponseObject> studentResetPassword(
            @PathVariable("token") String token,
            @RequestBody ResetPasswordRequest resetPasswordRequest
    ) {
        authenticationService.studentResetPassword(resetPasswordRequest, token);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(true, 200, "ok", "")
        );
    }
}

