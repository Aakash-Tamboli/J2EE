package bobby.test;
import com.thinking.machines.webrock.scope.*;
import com.thinking.machines.webrock.annotations.*;

@Path("/authenticationSystem")
public class AuthenticationSystem
{
@Path("/login")
@Forward("home.jsp") // here we have to talk to Sir or think if user not sign up or not authenticated then how can we prevent those jsp who is only accessible when user is authenticated
public void login(SessionScope sessionScope,@RequestParameter("nm") String name,@RequestParameter("password") String password)
{
// Assume name and password validate through db,
System.out.println("-------------------Authentication System --------------------");
System.out.println("Username: "+name);
System.out.println("Password: "+password);
if(sessionScope!=null) System.out.println("Session Scope is given by TMWebRock");
else System.out.println("null is given by TMWebRock in sessionScope");
// if following line is commented then this means we checked into our db and not found username and password, so we can't generate any token, hence out security guard will not allow this user
// when we are setting token into session or any scope it considered that user is authenticated
// sessionScope.setAttribute("token",password); 
}
}
