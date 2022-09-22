package enums;

public enum UrlsEnum {
    EXEMPLO_URL("http://seubarriga.wcaquino.me/login");

    private final String url;

    UrlsEnum(String value) {url = value;}

    public String getUrl(){return url;}
}
