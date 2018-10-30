var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
var ProductService = /** @class */ (function () {
    function ProductService(httpClient) {
        this.httpClient = httpClient;
    }
    // I'm subscribing inside the method to simplify the demo
    // A better solution is to return an observable and subscribe in the component
    /* The three dots are known as the spread operator from Typescript (also from ES7).
    The spread operator return all elements of an array. Like you would write each element separately:
    let myArr = [1, 2, 3];
    return [1, 2, 3];
    //is the same as:
    return [...myArr]; */
    ProductService.prototype.getProducts = function () {
        var products = [];
        /* En este caso se indica que la peticion get
        espera un array de objetos de tipo producto */
        this.httpClient.get('/api/products')
            .subscribe(function (data) { return products.push.apply(products, data); }, function (err) { return console.log(err); });
        return products;
    };
    ProductService.prototype.getProductById = function (productId) {
        var product = {};
        /* En este caso se indica que la peticion get
           que mediante el ID obtiene un objeto de tipo producto */
        this.httpClient.get("/api/products/" + productId)
            .subscribe(function (data) { return Object.assign(product, data); }, function (err) { return console.log(err); });
        return product;
    };
    ProductService = __decorate([
        Injectable(),
        __metadata("design:paramtypes", [HttpClient])
    ], ProductService);
    return ProductService;
}());
export { ProductService };
//# sourceMappingURL=product.service.js.map