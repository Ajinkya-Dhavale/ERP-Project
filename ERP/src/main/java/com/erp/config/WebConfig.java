package com.erp.config;

import com.erp.interceptor.AdminInterceptor;
import com.erp.interceptor.AccountInterceptor;
import com.erp.interceptor.LibraryInterceptor;
import com.erp.interceptor.ScholarshipInterceptor;
import com.erp.interceptor.StudentInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private AdminInterceptor adminInterceptor;

    @Autowired
    private AccountInterceptor accountInterceptor;

    @Autowired
    private LibraryInterceptor libraryInterceptor;

    @Autowired
    private ScholarshipInterceptor scholarshipInterceptor;

    @Autowired
    private StudentInterceptor studentInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Apply the AdminInterceptor to all /admin/** URLs
        registry.addInterceptor(adminInterceptor)
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/login");

        // Apply the AccountInterceptor to all /account/** URLs
        registry.addInterceptor(accountInterceptor)
                .addPathPatterns("/account/**");

        // Apply the LibraryInterceptor to all /library/** URLs
        registry.addInterceptor(libraryInterceptor)
                .addPathPatterns("/library/**");

        // Apply the ScholarshipInterceptor to all /scholarship/** URLs
        registry.addInterceptor(scholarshipInterceptor)
                .addPathPatterns("/scholarship/**");

        // Apply the StudentInterceptor to all /student/** URLs except /student/login
        registry.addInterceptor(studentInterceptor)
                .addPathPatterns("/student/**")
                .excludePathPatterns("/student/login");
    }
}