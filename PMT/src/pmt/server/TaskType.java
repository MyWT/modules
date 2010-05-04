package pmt.server;

import rnd.mywt.client.utils.ObjectUtils;
import rnd.mywt.server.bean.ApplicationJavaBean;

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