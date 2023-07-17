:spring_boot_version: 2.3.5.RELEASE
:spring-boot: https://github.com/edaaa/isteGelsinExample



== What You Need

:java_version: 15

----
./mvnw spring-boot:run
----

The actuator exposes the following:

:Depo Controller
* http://localhost:8080/depo
* http://localhost:8080/depo/close

:Product Controller

* http://localhost:8080/product

:Stock Controller
* http://localhost:8080/stock
* http://localhost:8080/transfer



== The Swagger Url

http://localhost:8080/swagger-ui.html#/
*{"swagger":"2.0","info":{"description":"User Api Dokümantasyonu","version":"1.12.3","title":"Spring Boot Swagger Examples","contact":{"name":"Eda Esmekaya"},"license":{"name":"Apache 2.0","url":"http://www.apache.org/licenses/LICENSE-2.0.html"}},"host":"localhost:8080","basePath":"/","tags":[{"name":"depo-controller","description":"Depo Controller"},{"name":"product-controller","description":"Product Controller"},{"name":"stock-controller","description":"Stock Controller"}],"paths":{"/depo":{"post":{"tags":["depo-controller"],"summary":"depo kaydetme işlemi gerçekleştirilir","operationId":"createDepoUsingPOST","consumes":["application/json"],"produces":["*/*"],"parameters":[{"in":"body","name":"depoDto","description":"depoDto","required":true,"schema":{"$ref":"#/definitions/DepoDto"}}],"responses":{"200":{"description":"OK","schema":{"$ref":"#/definitions/DepoCreateDto"}},"201":{"description":"Created"},"401":{"description":"Unauthorized"},"403":{"description":"Forbidden"},"404":{"description":"Not Found"}},"deprecated":false}},"/depo/close":{"post":{"tags":["depo-controller"],"summary":"depo kapatma işlemi gerçekleştirilir","operationId":"closeDepoUsingPOST","consumes":["application/json"],"produces":["*/*"],"parameters":[{"in":"body","name":"depoCloseDto","description":"depoCloseDto","required":true,"schema":{"$ref":"#/definitions/DepoCloseDto"}}],"responses":{"200":{"description":"OK","schema":{"$ref":"#/definitions/DepoResponse"}},"201":{"description":"Created"},"401":{"description":"Unauthorized"},"403":{"description":"Forbidden"},"404":{"description":"Not Found"}},"deprecated":false}},"/product":{"post":{"tags":["product-controller"],"summary":"urun kaydetme işlemi gerçekleştirilir","operationId":"createProductUsingPOST","consumes":["application/json"],"produces":["*/*"],"parameters":[{"in":"body","name":"product","description":"product","required":true,"schema":{"$ref":"#/definitions/ProductDto"}}],"responses":{"200":{"description":"OK","schema":{"$ref":"#/definitions/ProductCreateDto"}},"201":{"description":"Created"},"401":{"description":"Unauthorized"},"403":{"description":"Forbidden"},"404":{"description":"Not Found"}},"deprecated":false}},"/stock":{"post":{"tags":["stock-controller"],"summary":"stock kaydetme işlemi gerçekleştirilir","operationId":"addStockUsingPOST","consumes":["application/json"],"produces":["*/*"],"parameters":[{"in":"body","name":"stockSaveDto","description":"stockSaveDto","required":true,"schema":{"$ref":"#/definitions/StockSaveDto"}}],"responses":{"200":{"description":"OK","schema":{"$ref":"#/definitions/StockResponse"}},"201":{"description":"Created"},"401":{"description":"Unauthorized"},"403":{"description":"Forbidden"},"404":{"description":"Not Found"}},"deprecated":false}},"/transfer":{"post":{"tags":["stock-controller"],"summary":"stock transfer işlemi gerçekleştirilir","operationId":"transferStockUsingPOST","consumes":["application/json"],"produces":["*/*"],"parameters":[{"in":"body","name":"stockTransferDto","description":"stockTransferDto","required":true,"schema":{"$ref":"#/definitions/StockTransferDto"}}],"responses":{"200":{"description":"OK","schema":{"$ref":"#/definitions/StockResponse"}},"201":{"description":"Created"},"401":{"description":"Unauthorized"},"403":{"description":"Forbidden"},"404":{"description":"Not Found"}},"deprecated":false}}},"definitions":{"DepoCloseDto":{"type":"object","properties":{"depoId":{"type":"integer","format":"int64"}},"title":"DepoCloseDto"},"DepoCreateDto":{"type":"object","properties":{"message":{"type":"string"}},"title":"DepoCreateDto"},"DepoDto":{"type":"object","properties":{"city":{"type":"integer","format":"int32"},"cost_center":{"type":"string"},"depoType":{"type":"string","enum":["MAIN","DISTRIBUTION"]},"locationLat":{"type":"number","format":"double"},"locationLong":{"type":"number","format":"double"},"name":{"type":"string"},"status":{"type":"boolean"}},"title":"DepoDto"},"DepoResponse":{"type":"object","properties":{"message":{"type":"string"}},"title":"DepoResponse"},"ProductCreateDto":{"type":"object","properties":{"message":{"type":"string"}},"title":"ProductCreateDto"},"ProductDto":{"type":"object","properties":{"barcode":{"type":"string"},"frozen":{"type":"boolean"},"name":{"type":"string"},"price":{"type":"number","format":"double"},"sku":{"type":"string"},"stocks":{"type":"integer","format":"int32"},"type":{"type":"string","enum":["FOOD","CLEANING","UPPLIES"]},"unitType":{"type":"string"}},"title":"ProductDto"},"StockResponse":{"type":"object","properties":{"message":{"type":"string"}},"title":"StockResponse"},"StockSaveDto":{"type":"object","properties":{"count":{"type":"integer","format":"int32"},"depoId":{"type":"integer","format":"int64"},"productId":{"type":"integer","format":"int64"}},"title":"StockSaveDto"},"StockTransferDto":{"type":"object","properties":{"count":{"type":"integer","format":"int32"},"fromDepoId":{"type":"integer","format":"int64"},"productId":{"type":"integer","format":"int64"},"toDepoId":{"type":"integer","format":"int64"}},"title":"StockTransferDto"}}}