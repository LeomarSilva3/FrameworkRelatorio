package enums;

public enum NomeProjetoEnum {

    NOME_PROJETO_ENUM("java");

    private final String projetoName;

    NomeProjetoEnum(String value) {projetoName = value;}

    public String getProjetoName(){
        return projetoName;}
}
