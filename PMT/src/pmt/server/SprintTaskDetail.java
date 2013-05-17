package pmt.server;

import rnd.mywt.server.bean.ApplicationJavaBean;
import rnd.utils.ObjectUtils;

public class SprintTaskDetail extends ApplicationJavaBean {

   private Long taskId;
   
   public Sprint sprint;
   
   
   public Long getTaskId() {
      return taskId;
   }
   
   public void setTaskId(Long newTaskId) {
      if (ObjectUtils.areEqual(this.taskId, newTaskId)) { return; }
      this.taskId = newTaskId;
   }
   
   
   public Sprint getSprint() {
      return sprint;
   }
   
   public void setSprint(Sprint newSprint) {
      if (ObjectUtils.areEqual(this.sprint, newSprint)) { return; }
      this.sprint = newSprint;
   }
}