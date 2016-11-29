<#import "masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Receipt book">
    <#if data??>
    <div class="row">
        <div class="col-md-12">
            <table class="table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Product Name</th>
                        <th>Currency</th>
                        <th>Price</th>
                        <th>Purchase Date</th>
                        <th>Warranty Date</th>
                        <th>Category</th>
                        <th>Shop Name</th>
                        <th>Shop Invoice</th>
                        <th>Shop Address</th>
                        <th>Shop Phone</th>
                        <th>Remarks</th>
                    </tr>
                </thead>
                <tbody>
                    <#list data as receipt>
                        <tr>
                            <td>${receipt.getId()}</td>
                            <td>${receipt.getProductName()}</td>
                            <td>${receipt.getCurrency()}</td>
                            <td>${receipt.getPrice()}</td>
                            <td>${receipt.getPurchaseDate()}</td>
                            <td>${receipt.getWarrantyDate()}</td>
                            <td>${receipt.getCategory()!'N/A'}</td>
                            <td>${receipt.getShopName()!'N/A'}</td>
                            <td>${receipt.getShopInvoice()!'N/A'}</td>
                            <td>${receipt.getShopAddress()!'N/A'}</td>
                            <td>${receipt.getShopPhone()!'N/A'}</td>
                            <td>${receipt.getRemarks()!'N/A'}</td>
                        </tr>
                    </#list>
                </tbody>
            </table>
        </div>
    </div>
    <#else>
        There are no phone numbers yet.
    </#if>
</@layout.masterTemplate>