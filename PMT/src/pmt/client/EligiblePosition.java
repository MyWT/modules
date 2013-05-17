package pmt.client;

import rnd.bean.ApplicationDynaBean;

public class EligiblePosition extends ApplicationDynaBean {

   
   public Long getPositionId() {
      return (Long) getValue("positionId");
   }
   
   public void setPositionId(Long newPositionId) {
      setValue("positionId", newPositionId);
   }
   
   
   public TeamPosition getTeamPosition() {
      return (TeamPosition) getValue("teamPosition");
   }
   
   public void setTeamPosition(TeamPosition newTeamPosition) {
      setValue("teamPosition", newTeamPosition);
   }
}