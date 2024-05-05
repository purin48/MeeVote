package today.meevote.contextholder;

public class MemberContextHolder {
    private static final ThreadLocal<String> emailContext = new ThreadLocal<>();

    public static void setEmail(String email) {
    	emailContext.set(email);
    }

    public static String getEmail() {
        return emailContext.get();
    }

	public static void clear() {
		emailContext.remove();
	}
}
