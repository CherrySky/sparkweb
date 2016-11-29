<#import "masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Receipt book">
    <#if data??>
    <div class="row">
        <div class="col-md-6">
            <table class="table table-condensed">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Product Name</th>
                    </tr>
                </thead>
                <tbody>
                    <#list data as receipt>
                        <tr>
                            <td>${receipt.getId()}</td>
                            <td>${receipt.getProductName()}</td>
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