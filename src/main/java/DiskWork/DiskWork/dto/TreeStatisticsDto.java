package DiskWork.DiskWork.dto;

import java.util.List;

public class TreeStatisticsDto {
    private int height;
    private int redBlackRatio;
    private List<Integer> nodesByLevel;
    private String message;

    public TreeStatisticsDto() {}

    public TreeStatisticsDto(int height, int redBlackRatio, List<Integer> nodesByLevel, String message) {
        this.height = height;
        this.redBlackRatio = redBlackRatio;
        this.nodesByLevel = nodesByLevel;
        this.message = message;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getRedBlackRatio() {
        return redBlackRatio;
    }

    public void setRedBlackRatio(int redBlackRatio) {
        this.redBlackRatio = redBlackRatio;
    }

    public List<Integer> getNodesByLevel() {
        return nodesByLevel;
    }

    public void setNodesByLevel(List<Integer> nodesByLevel) {
        this.nodesByLevel = nodesByLevel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
