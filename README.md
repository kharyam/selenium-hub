# Selenium hub on OCP

## Directories
* kustomize/ - kustomize configuration for deploying selenium hub and nodes on OCP
* sample-test/ - Example maven project for connecting to the hub. Update `AppTest.java` with the selenium hub endpoint then run `mvn test`

```bash
oc adm policy add-scc-to-user -z selenium restricted
oc apply -k kustomize
```
