package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Entity
public class Advert extends Model {

  @Id
  public Long id;

  @Constraints.Required
  public String parsedSystem; // TODO enum: ss.lv, reallat.lv, ...

  public String advertismentUrl;

  public Short floor;

  public Short floorsTotal;

  public Short rooms;

  public String project; // TODO: enum 102, 140, 119, ...

  public String address;// TODO : split to city, street, number ...

  @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  public Date systemCreated;

  public static final Model.Finder<Long, Advert> FIND = new Model.Finder<Long, Advert>(Long.class, Advert.class);

  public static List<Advert> findByAddress(String address) {
    return FIND.where().like("address", address).findList();
  }
}
