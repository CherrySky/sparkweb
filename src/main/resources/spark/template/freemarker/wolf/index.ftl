<#import "../masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Wolfs">
    <#if data??>
    <div class="row">
        <div class="col-md-15">
            <table class="table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Games Played Total</th>
                        <th>Games Won</th>
                        <th>Games Won %</th>
                        <th>Games Lost</th>
                        <th>Games Lost %</th>
                        <th>Games Survived</th>
                        <th>Games Survived %</th>
                        <th>Most Common Role</th>
                        <th>Most Common Role %</th>
                        <th>Most Killed</th>
                        <th>Most Killed Times</th>
                        <th>Most Killed By</th>
                        <th>Most Killed ByTimes</th>
                    </tr>
                </thead>
                <tbody>
                    <#list data as wolf>
                        <tr>
                            <td>${wolf.getUserId()}</td>
                            <td><b>${wolf.getName()}</b></td>
                            <td>${wolf.getGamesPlayedTotal()}</td>
                            <td>${wolf.getWon()}</td>
                            <td>${wolf.getWonPercentage()}</td>
                            <td>${wolf.getLost()}</td>
                            <td>${wolf.getLostPercentage()!'N/A'}</td>
                            <td>${wolf.getSurvived()!'N/A'}</td>
                            <td>${wolf.getSurvivedPercentage()!'N/A'}</td>
                            <td>${wolf.getMostCommonRole()!'N/A'}</td>
                            <td>${wolf.getMostCommonRoleTimes()!'N/A'}</td>
                            <td><a href="http://www.tgwerewolf.com/Stats/Player/${wolf.getMostKilled()}" class="btn btn-xs btn-info">${wolf.getMostKilledName()}</a<</td>
                            <td>${wolf.getMostKilledTimes()!'N/A'}</td>
                            <td><a href="http://www.tgwerewolf.com/Stats/Player/${wolf.getMostKilledBy()}" class="btn btn-xs btn-info">${wolf.getMostKilledByName()}</a<</td>
                            <td>${wolf.getMostKilledByTimes()!'N/A'}</td>
                        </tr>
                    </#list>
                </tbody>
            </table>
        </div>
    </div>
    <#else>
        There are no wolfs yet.
    </#if>
</@layout.masterTemplate>