package bobby.test;
import com.thinking.machines.webrock.scopes.*;
import com.thinking.machines.webrock.annotations.*;

@Path("/authenticationSystem")
public class AuthenticationSystem
{
@Path("/login")
@Forward("home.jsp")
public void login(@RequestParameter("username") String username,@RequestParameter("password") String password,SessionScope sessionScope)
{
System.out.println("UserName: ["+username+"]");
System.out.println("password: ["+password+"]");
sessionScope.setAttribute("isUserAuthenticated",username+password);
}
}
