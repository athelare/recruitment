package com.ctl.recruitment.pojo.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "job_application", schema = "campus_recruitment")
public class JobApplicationEntity {
    static enum JobStatus{
        SUBMITTED,IGNORE,PROCESSING,FINISHED
    }
    private int applicationId;
    private JobStatus status;
    private StudentEntity studentByStudentId;
    private JobEntity jobByJobId;
    private ResumeEntity resumeByResumeId;

    @Id
    @Column(name = "application_id", nullable = false)
    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = true)
    public JobStatus getStatus() {
        return status;
    }

    public void setStatus(JobStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobApplicationEntity that = (JobApplicationEntity) o;
        return applicationId == that.applicationId &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicationId, status);
    }

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", nullable = false)
    public StudentEntity getStudentByStudentId() {
        return studentByStudentId;
    }

    public void setStudentByStudentId(StudentEntity studentByStudentId) {
        this.studentByStudentId = studentByStudentId;
    }

    @ManyToOne
    @JoinColumn(name = "job_id", referencedColumnName = "job_id")
    public JobEntity getJobByJobId() {
        return jobByJobId;
    }

    public void setJobByJobId(JobEntity jobByJobId) {
        this.jobByJobId = jobByJobId;
    }

    @ManyToOne
    @JoinColumn(name = "resume_id", referencedColumnName = "resume_id")
    public ResumeEntity getResumeByResumeId() {
        return resumeByResumeId;
    }

    public void setResumeByResumeId(ResumeEntity resumeByResumeId) {
        this.resumeByResumeId = resumeByResumeId;
    }
}
