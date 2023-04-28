import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        App app=new App();

        System.out.println("Please enter your username : ");
        String username = sc.nextLine();
        System.out.println("Please enter your password : ");
        String password = sc.nextLine();
        System.out.println("Please enter target profile name : ");
        String targetProfileName = sc.nextLine();

        app.loginWith(username,password);
        app.navigateToProfile(targetProfileName);
        app.clickFirstPost();
        app.likeAllPost(app.getPostCount());

    }
}