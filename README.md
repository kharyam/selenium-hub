# Selenium hub on OCP

## Directories
* kustomize/ - kustomize configuration for deploying selenium hub and nodes on OCP
* sample-test/ - Example maven project for connecting to the hub. Update `AppTest.java` with the selenium hub endpoint then run `mvn test`

## Notes

### Env Vars

* `SE_VNC_PASSWORD` - override the default VNC password of "secret"
* `SE_OPTS` - set additional node command line options
