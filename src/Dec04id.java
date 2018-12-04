import java.time.LocalDateTime;



class Dec04id{
    private LocalDateTime localDateTime;
    private int id;
    private String status;

    public Dec04id(LocalDateTime localDateTime, int id, String status) {
        this.localDateTime = localDateTime;
        this.id = id;
        this.status = status;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    @Override
    public String toString() {
        return "Dec04id{" +
                "localDateTime=" + localDateTime +
                ", id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
