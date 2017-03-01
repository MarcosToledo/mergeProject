package br.com.sisnoti.modules.client;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.sisnoti.modules.broker.Broker;
import br.com.sisnoti.modules.event.Event;
import br.com.sisnoti.modules.notification.Notification;
import br.com.sisnoti.modules.user.User;

/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@Table(name = "client")
@XmlRootElement
public class Client implements Serializable {
	private static final long serialVersionUID = -6424598609428279761L;

	@Id
	private int id;

	private byte actived;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_register")
	private Date dateRegister;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_update")
	private Date dateUpdate;

	private String document;

	private String name;

	private String phone;

	// bi-directional many-to-one association to Broker
	@OneToMany(mappedBy = "client")
	private List<Broker> brokers;

	// bi-directional many-to-one association to Event
	@OneToMany(mappedBy = "client")
	private List<Event> events;

	// bi-directional many-to-one association to Notification
	@OneToMany(mappedBy = "client")
	private List<Notification> notifications;

	// bi-directional many-to-one association to User
	@OneToMany(mappedBy = "client")
	private List<User> users;

	public Client() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getActived() {
		return this.actived;
	}

	public void setActived(byte actived) {
		this.actived = actived;
	}

	public Date getDateRegister() {
		return this.dateRegister;
	}

	public void setDateRegister(Date dateRegister) {
		this.dateRegister = dateRegister;
	}

	public Date getDateUpdate() {
		return this.dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public String getDocument() {
		return this.document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Broker> getBrokers() {
		return this.brokers;
	}

	public void setBrokers(List<Broker> brokers) {
		this.brokers = brokers;
	}

	public Broker addBroker(Broker broker) {
		getBrokers().add(broker);
		broker.setClient(this);

		return broker;
	}

	public Broker removeBroker(Broker broker) {
		getBrokers().remove(broker);
		broker.setClient(null);

		return broker;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setClient(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setClient(null);

		return event;
	}

	public List<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public Notification addNotification(Notification notification) {
		getNotifications().add(notification);
		notification.setClient(this);

		return notification;
	}

	public Notification removeNotification(Notification notification) {
		getNotifications().remove(notification);
		notification.setClient(null);

		return notification;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setClient(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setClient(null);

		return user;
	}

}