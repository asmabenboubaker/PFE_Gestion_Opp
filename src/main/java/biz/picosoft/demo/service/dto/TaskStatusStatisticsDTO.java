package biz.picosoft.demo.service.dto;

public class TaskStatusStatisticsDTO {

    private String status;
    private Long count;

    public TaskStatusStatisticsDTO(String status, Long count) {
        this.status = status;
        this.count = count;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
