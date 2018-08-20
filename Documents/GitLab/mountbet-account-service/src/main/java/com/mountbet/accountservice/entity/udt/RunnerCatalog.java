package com.mountbet.accountservice.entity.udt;

import com.datastax.driver.core.DataType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Map;

@UserDefinedType("runner_catalog")
public class RunnerCatalog {
    @Column(value = "selection_id")
    @CassandraType(type = DataType.Name.BIGINT)
    private Long selectionId;

    @Column(value = "runner_name")
    @CassandraType(type = DataType.Name.TEXT)
    private String runnerName;

    @Column(value = "handicap")
    @CassandraType(type = DataType.Name.DOUBLE)
    private Double handicap;

    @Column(value = "sort_priority")
    @CassandraType(type = DataType.Name.INT)
    private Integer sortPriority;

    @Column(value = "metadata")
    @CassandraType(type = DataType.Name.MAP, typeArguments = {DataType.Name.TEXT, DataType.Name.TEXT})
    private Map<String, String> metadata;

    public Long getSelectionId() {
        return selectionId;
    }

    public void setSelectionId(Long selectionId) {
        this.selectionId = selectionId;
    }

    public String getRunnerName() {
        return runnerName;
    }

    public void setRunnerName(String runnerName) {
        this.runnerName = runnerName;
    }

    public Double getHandicap() {
        return handicap;
    }

    public void setHandicap(Double handicap) {
        this.handicap = handicap;
    }

    public Integer getSortPriority() {
        return sortPriority;
    }

    public void setSortPriority(Integer sortPriority) {
        this.sortPriority = sortPriority;
    }

    public Map<String, String> getMetadata() {
        return convertNullToEmpty(metadata);
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = convertNullToEmpty(metadata);
    }

    private Map<String, String> convertNullToEmpty(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue() == null) {
                map.put(entry.getKey(), "");
            }
        }
        return map;
    }

    @Override
    public String toString() {
        return "Runner{" +
                "selectionId=" + selectionId +
                ", runnerName='" + runnerName + '\'' +
                ", handicap=" + handicap +
                ", sortPriority=" + sortPriority +
                ", metadata=" + metadata +
                '}';
    }
}