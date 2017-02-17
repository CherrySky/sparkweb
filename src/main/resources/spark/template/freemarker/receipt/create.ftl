<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Receipt">
<form action="updateReceipt" method="post">
  <div class="form-group">
    <label for="productName">Product Name</label>
    <input type="text" class="form-control" id="productName" aria-describedby="productName" <#if data??>value="${data.getProductName()!''}"</#if> placeholder="Product Name">
  </div>
  <div class="form-group">
    <label for="purchaseDate">Purchase Date</label>
    <input type="date" class="form-control" id="purchaseDate" aria-describedby="purchaseDate" <#if data??>value="${data.getPurchaseDate()!''}"</#if> placeholder="Purchase Date">
  </div>


  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</@layout.masterTemplate>