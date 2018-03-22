package ua.org.oa._dani4_.model.elements;

import java.util.Date;

/**
 * Created by Admin on 03.04.2016.
 */
public class Report {
    //id РѕС‚С‡РµС‚Р°
    private int id;
    //РєРЅРёРіР° Рє РєРѕС‚РѕСЂРѕР№ РѕС‚РЅРѕСЃРёС‚СЃСЏ РѕС‚С‡РµС‚
    private int book_id;
    //СЋР·РµСЂ, Рє РєРѕС‚РѕСЂРѕРјСѓ РѕС‚РЅРѕСЃРёС‚СЃСЏ РѕС‚С‡РµС‚
    private int user_id;
    //РґР°С‚Р° РєРѕРіРґР° РєРЅРёРіСѓ РІР·СЏР»Рё РёР· Р±РёР±Р»РёРѕС‚РµРєРё
    private Date rent;
    //РґР°С‚Р° РєРѕРіРґР° РєРЅРёРіСѓ РІРµСЂРЅСѓР»Рё РІ Р±РёР±Р»РёРѕС‚РµРєСѓ
    private Date returns = null;

    public Report(int book_id, Date rent, int user_id) {
        this.setBookID(book_id);
        this.setRent(rent);
        this.setUserID(user_id);
    }
    public Report(int book_id, Date rent, int user_id, Date returns) {
        this.setBookID(book_id);
        this.setRent(rent);
        this.setUserID(user_id);
        this.setReturns(returns);
    }

    public int getUserID() {
        return user_id;
    }

    public void setUserID(int user_id) {
        this.user_id = user_id;
    }

    public Date getReturns() {
        return returns;
    }

    public void setReturns(Date returns) {
        this.returns = returns;
    }

    public Date getRent() {
        return rent;
    }

    public void setRent(Date rent) {
        this.rent = rent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookID() {
        return book_id;
    }

    public void setBookID(int book_id) {
        this.book_id = book_id;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ReportDTO{");
        sb.append("book_id=").append(book_id);
        sb.append(", id=").append(id);
        sb.append(", user_id=").append(user_id);
        sb.append(", rent=").append(rent);
        sb.append(", returns=").append(returns);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Report report = (Report) o;

        if (getId() != report.getId()) return false;
        if (book_id != report.book_id) return false;
        if (user_id != report.user_id) return false;
        if (getRent() != null ? !getRent().equals(report.getRent()) : report.getRent() != null) return false;
        return getReturns() != null ? getReturns().equals(report.getReturns()) : report.getReturns() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + book_id;
        result = 31 * result + user_id;
        result = 31 * result + (getRent() != null ? getRent().hashCode() : 0);
        result = 31 * result + (getReturns() != null ? getReturns().hashCode() : 0);
        return result;
    }
}
