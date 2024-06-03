package biz.picosoft.demo.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Objects;

@Entity
@Table(name = "task",schema = "opportunite")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subject;
    private String details ;
    private String priority;
    private String status;
    private LocalDate start_date;
    private LocalDate end_date;
    private String assignee;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Projet project;

    public Projet getProject() {
        return project;
    }

    public void setProject(Projet project) {
        this.project = project;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(subject, task.subject) && Objects.equals(details, task.details) && Objects.equals(priority, task.priority) && Objects.equals(status, task.status) && Objects.equals(start_date, task.start_date) && Objects.equals(end_date, task.end_date) && Objects.equals(assignee, task.assignee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subject, details, priority, status, start_date, end_date, assignee);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", details='" + details + '\'' +
                ", priority='" + priority + '\'' +
                ", status='" + status + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", assignee='" + assignee + '\'' +
                '}';
    }
}
