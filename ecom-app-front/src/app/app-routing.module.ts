import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ProductsComponent} from "./ui/products/products.component";
import {CustomersComponent} from "./ui/customers/customers.component";
import {AuthGuard} from "./guards/auth.guard";
import {OrdersComponent} from "./ui/orders/orders.component";
import {OrderDetailsComponent} from "./ui/order-details/order-details.component";
import {HomeComponent} from "./ui/home/home.component";
import {ProductDetailsComponent} from "./ui/product-details/product-details.component";
import {NotFountComponent} from "./ui/not-fount/not-fount.component";

export const routes: Routes = [
  {path: "products", component: ProductsComponent},
  {path: "customers", component: CustomersComponent, canActivate: [AuthGuard], data: {roles: ['USER']}},
  {path: "orders", component: OrdersComponent, canActivate: [AuthGuard], data: {roles: ['ADMIN']}},
  {path: "orders/:orderId", component: OrderDetailsComponent, canActivate: [AuthGuard], data: {roles: ['ADMIN']}},
  {path: "", component: HomeComponent},
  { path: '**', component: NotFountComponent },
  {path: "products/:productId", component: ProductDetailsComponent, canActivate: [AuthGuard], data: {roles: ['USER']}},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
