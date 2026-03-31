package stockExchange.model;

import java.util.Objects;

public class Stock {
    private final String symbol;
    private final String companyName;
    private final String parentCompany;
    private final String industry;

    public Stock(String symbol, String companyName, String parentCompany, String industry) {
        this.symbol = symbol;
        this.companyName = companyName;
        this.parentCompany = parentCompany;
        this.industry = industry;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getParentCompany() {
        return parentCompany;
    }

    public String getIndustry() {
        return industry;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "symbol='" + symbol + '\'' +
                ", companyName='" + companyName + '\'' +
                ", parentCompany='" + parentCompany + '\'' +
                ", industry='" + industry + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(!(obj instanceof Stock)|| obj == null) return false;
        Stock st = (Stock) obj;
        return Objects.equals(this.symbol, st.getSymbol());
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.symbol);
    }
}
