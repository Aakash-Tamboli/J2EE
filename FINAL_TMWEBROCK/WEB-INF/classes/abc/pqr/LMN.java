package abc.pqr;
import com.thinking.machines.webrock.scope.*;



public class LMN
{
public void efgh(ApplicationDirectory applicationDirectory,ApplicationScope applicationScope,SessionScope sessionScope,RequestScope requestScope)
{
System.out.println("---------------------abc.pqr.LMN-------------------------------");
if(applicationDirectory!=null) System.out.println("applicationDirectory is given by TMWebRock Framework");
else System.out.println("Some Problem while giving applicationDirectory");

if(applicationScope!=null) System.out.println("applicationScope is given by TMWebRock Framework");
else System.out.println("Some Problem while giving applicationScope");

if(sessionScope!=null) System.out.println("SessionScope is given by TMWebRock Framework");
else System.out.println("Some Problem while giving SessionScopeDirectory");

if(requestScope!=null) System.out.println("RequestScope is given by TMWebRock Framework");
else System.out.println("Some Problem while giving RequestScope");

String token=(String)sessionScope.getAttribute("token");
System.out.printf("[%s]\n",token);
// assume here we checked that token thing with in our db or data structure
if(token!=null && token.length()>0) System.out.println("User is found logged in");
else throw new SecurityException("User Not Logged In");

System.out.println("---------------------abc.pqr.LMN-------------------------------");
}
}
