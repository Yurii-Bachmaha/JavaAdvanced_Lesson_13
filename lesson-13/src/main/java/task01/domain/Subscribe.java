package task01.domain;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "subscribe")
public class Subscribe {
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "magazine_id", referencedColumnName = "id")
	private Magazine magazine;
	
	@Column(name = "subscribe_status")
	private boolean subscribeStatus;
	
	@Column(name = "subscribe_date")
	private Date subscribeDate;
	
	@Column(name = "subscribe_period")
	private Integer subscribePeriod;

	public Subscribe() {
	}

	public Subscribe(Integer id, User user, Magazine magazine, boolean subscribeStatus, Date subscribeDate,
			Integer subscribePeriod) {
		this.id = id;
		this.user = user;
		this.magazine = magazine;
		this.subscribeStatus = subscribeStatus;
		this.subscribeDate = subscribeDate;
		this.subscribePeriod = subscribePeriod;
	}

	public Subscribe(User user, Magazine magazine, boolean subscribeStatus, Date subscribeDate,
			Integer subscribePeriod) {
		this.user = user;
		this.magazine = magazine;
		this.subscribeStatus = subscribeStatus;
		this.subscribeDate = subscribeDate;
		this.subscribePeriod = subscribePeriod;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Magazine getMagazine() {
		return magazine;
	}

	public void setMagazine(Magazine magazine) {
		this.magazine = magazine;
	}

	public boolean isSubscribeStatus() {
		return subscribeStatus;
	}

	public void setSubscribeStatus(boolean subscribeStatus) {
		this.subscribeStatus = subscribeStatus;
	}

	public Date getSubscribeDate() {
		return subscribeDate;
	}

	public void setSubscribeDate(Date subscribeDate) {
		this.subscribeDate = subscribeDate;
	}

	public Integer getSubscribePeriod() {
		return subscribePeriod;
	}

	public void setSubscribePeriod(Integer subscribePeriod) {
		this.subscribePeriod = subscribePeriod;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, magazine, subscribeDate, subscribePeriod, subscribeStatus, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subscribe other = (Subscribe) obj;
		return Objects.equals(id, other.id) && Objects.equals(magazine, other.magazine)
				&& Objects.equals(subscribeDate, other.subscribeDate)
				&& Objects.equals(subscribePeriod, other.subscribePeriod) && subscribeStatus == other.subscribeStatus
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Subscribe id = " + id + ", userId = " + user.getId() + ", magazineId = " + magazine.getId()
				+ ", subscribeStatus = " + subscribeStatus + ", subscribeDate = " + subscribeDate
				+ ", subscribePeriod = " + subscribePeriod + " months";
	}

}