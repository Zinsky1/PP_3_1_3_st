# PP_3_1_3_st

Написал Web-Secured CRUD приложение, работает.

как и требуется
    User имеет доступ только к странице /user, а админ к /admin, где реализован CRUD.

    Использовал:
     UserDetails <- UserDetailsService <- DaoAuthenticationProvider
     PasswordEncoder
     SuccessHandler

    Не понял зачем нужен GrantedAuthorities и getAuthority();,
    если у UserDetails есть
        public Collection<? extends GrantedAuthority> getAuthorities();

    Role создал с помощью Enum. (Как лучше реализовать роль? Enum или Сlass?)
