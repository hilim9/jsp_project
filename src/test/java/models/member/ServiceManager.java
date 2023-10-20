package models.member;

public class ServiceManager {

    // 싱글톤 패턴 S
    private static ServiceManager instance;

    public static ServiceManager getInstance() {

        if (instance == null) {
            instance = new ServiceManager();
        }

        return instance;
    }
    // 싱글톤 패턴 E

    private ServiceManager() {

    }

    public MemberDao memberDao() {

        return new MemberDao();
    }

    public JoinValidator joinValidator() {

        JoinValidator validator = new JoinValidator();
        validator.setMemberDao(memberDao());

        return validator;
    }

    public JoinService joinService() {

        return new JoinService(joinValidator(), memberDao());
    }

    public LoginValidator loginValidator() {
        return new LoginValidator(memberDao());
    }

    public LoginService loginService() {

        return new LoginService(loginValidator(), memberDao());
    }
}
