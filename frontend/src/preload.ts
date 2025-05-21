import { contextBridge } from 'electron'

contextBridge.exposeInMainWorld('electronAPI', {
  // 여기에 ipcRenderer 메소드 안전하게 노출
})
