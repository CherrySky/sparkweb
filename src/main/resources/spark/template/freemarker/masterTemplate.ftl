<#macro masterTemplate title="">
    <!DOCTYPE html
            PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
            "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
    <html xmlns="http://www.w3.org/1999/xhtml">
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
            <link href="/css/bootstrap.css" rel="stylesheet">
            <link href="/css/starter-template.css" rel="stylesheet">
            <title>${title}</title>
        </head>
        <body>
            <nav class="navbar navbar-inverse navbar-fixed-top">
                  <div class="container">
                    <div class="navbar-header">
                      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                      </button>
                      <a class="navbar-brand" href="/">Don</a>
                    </div>
                    <div id="navbar" class="collapse navbar-collapse">
                      <ul class="nav navbar-nav">
                        <li><a href="/wolf">Wolfs</a></li>
                        <li><a href="/nihongo">日語</a></li>
                        <li><a href="/chat">Chat</a>Chat</li>
                        <!--<li class="active"><a href="#about">About</a></li>
                        <li><a href="#contact">Contact</a></li>-->
                      </ul>
                      <!--<form class="navbar-form navbar-right" action="searchReceipt" method="post">
                          <div class="form-group">
                            <input type="text" name="search" placeholder="Search" class="form-control">
                          </div>
                          <button type="submit" class="btn btn-success">Search</button>
                        </form>-->
                    </div><!--/.nav-collapse -->
                  </div>
                </nav>

                <div class="container">

                  <div class="starter-template">
                    <#nested />
                  </div>

                </div><!-- /.container -->


                <!-- Bootstrap core JavaScript
                ================================================== -->
                <!-- Placed at the end of the document so the pages load faster -->
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
                <script src="/js/bootstrap.min.js"></script>
        </body>
    </html>
</#macro>