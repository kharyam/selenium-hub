# Selenium hub on OCP

## kustomize

kustomize configuration for deploying selenium hub and nodes on OCP.
```bash
# Set the installation namespace
export NAMESPACE=selenium-hub

# Grant the restricted SCC to the selenium service account. By default
# the service account belongs to the restricted-v2 SCC.  We require the
# use of restricted to allow additional privileges specifically for the
# firefox node.
oc adm policy add-scc-to-user restricted -z selenium -n $NAMESPACE

# Deploy using kustomize
oc apply -k ./kustomize -n $NAMESPACE

# Create a route
oc expose svc/selenium
```

## sample-test
Example maven project for connecting to the hub. Update `AppTest.java` with the selenium hub endpoint (if necessary) then run `mvn test`

## Notes

* The deployments are setting `SE_OFFLINE` to `"true"` to prevent the session manager from attempting to download (unecessary) drivers from the internet
