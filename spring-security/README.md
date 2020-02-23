# Read Me First
  To configure security in spring boot application. it's very easy we just need to add spring-security-starter dependency
  in pom file and spring will add the security watch man in front of our application. So all the request coming from outer world
  must pass through from spring security filter. it will ask 2 question for every request who you are? (Authentication)
  Can you perform this action? or what do you want to do? (Authorization).

  Spring security also add login logout page and error page in your application.

  Once we add spring-security dependency it will generate default password each time on application restart.
  we can over write it by setting up properties spring.security.user.name spring.security.user.password in application.property file.
  Default user name for spring security is "user".

  e.g. TestController test() method.

  But in real world application above method can't help as we need real user info from DB or LDAP etc.

  Spring provides you Authentication Manager. Which can authenticate user for you. To do this we need to configure
  it via WebSecurityConfigurerAdaptor class. It has built in method which accept AuthenticationManagerBuilder object
  where you can pass your configure via method chaining.

  Checkout the Spring security filter -> AuthenticationManager -> AuthenticationProvider -> UserDetailService  diagram in google docs

   https://docs.google.com/document/d/1QDmED5Po6Ixzr7iFMcN8-HsaWSOm9_xLNXhzSbTMkTM/edit#


  e.g. TestController user().



   <h2>Concepts/Terminology</h2>
   Principal : A logged in user or session
   Granted Authority : Given permission to perform specific task in application
   Role      : Group of authority so that permission can be manage easily







