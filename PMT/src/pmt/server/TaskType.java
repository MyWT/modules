package pmt.server;

import rnd.mywt.server.bean.ApplicationJavaBean;
import rnd.utils.ObjectUtils;

public class TaskType extends ApplicationJavaBean {

   private String taskType;
   
   public String getTaskType() {
      return taskType;
   }
   
   public void setTaskType(String newTaskType) {
      if (ObjectUtils.areEqual(this.taskType, newTaskType)) { return; }
      this.taskType = newTaskType;
   }
}