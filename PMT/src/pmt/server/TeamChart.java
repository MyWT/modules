package pmt.server;

import rnd.mywt.client.utils.ObjectUtils;
import rnd.mywt.server.bean.ApplicationJavaBean;

public class TeamChart extends ApplicationJavaBean {

   private String chartName;
   
   private Long teamStructureId;
   
   private Long rootTeamPositionHolderId;
   
   public String getChartName() {
      return chartName;
   }
   
   public void setChartName(String newChartName) {
      if (ObjectUtils.areEqual(this.chartName, newChartName)) { return; }
      this.chartName = newChartName;
   }
   public Long getTeamStructureId() {
      return teamStructureId;
   }
   
   public void setTeamStructureId(Long newTeamStructureId) {
      if (ObjectUtils.areEqual(this.teamStructureId, newTeamStructureId)) { return; }
      this.teamStructureId = newTeamStructureId;
   }
   
   public Long getRootTeamPositionHolderId() {
      return rootTeamPositionHolderId;
   }
   
   public void setRootTeamPositionHolderId(Long newRootTeamPositionHolderId) {
      if (ObjectUtils.areEqual(this.rootTeamPositionHolderId, newRootTeamPositionHolderId)) { return; }
      this.rootTeamPositionHolderId = newRootTeamPositionHolderId;
   }
}