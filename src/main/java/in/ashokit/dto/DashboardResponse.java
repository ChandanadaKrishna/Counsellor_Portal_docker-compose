package in.ashokit.dto;

public class DashboardResponse {
    private Integer totalEnq;
    private Integer openEnq;
    private Integer lostEnq;
    private Integer enrolledEnq;

    public Integer getTotalEnq() {
        return totalEnq;
    }

    public void setTotalEnq(Integer totalEnq) {
        this.totalEnq = totalEnq;
    }

    public Integer getOpenEnq() {
        return openEnq;
    }

    public void setOpenEnq(Integer openEnq) {
        this.openEnq = openEnq;
    }

    public Integer getLostEnq() {
        return lostEnq;
    }

    public void setLostEnq(Integer lostEnq) {
        this.lostEnq = lostEnq;
    }

    public Integer getEnrolledEnq() {
        return enrolledEnq;
    }

    public void setEnrolledEnq(Integer enrolledEnq) {
        this.enrolledEnq = enrolledEnq;
    }


}
