var mime_samples = [
  { 'mime': 'application/xhtml+xml', 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/', 'dir': '_m0/0', 'linked': 2, 'len': 4626 },
    { 'url': 'http://paris.idi.ntnu.no:6280/sfi9876', 'dir': '_m0/1', 'linked': 2, 'len': 1082 },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activateCustomer.do', 'dir': '_m0/2', 'linked': 2, 'len': 1272 },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addAddress.jsp', 'dir': '_m0/3', 'linked': 2, 'len': 846 },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/customerSupport.jsp', 'dir': '_m0/4', 'linked': 2, 'len': 1437 },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/', 'dir': '_m0/5', 'linked': 5, 'len': 1228 },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/sfi9876.do', 'dir': '_m0/6', 'linked': 5, 'len': 1468 },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/debug/list_books.jsp', 'dir': '_m0/7', 'linked': 2, 'len': 189252 },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/viewCart.do;jsessionid=3aaabdf69ad70d900703cadea75b', 'dir': '_m0/8', 'linked': 2, 'len': 627 },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activationError.do', 'dir': '_m0/9', 'linked': 2, 'len': 804 },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activationSuccessful.do', 'dir': '_m0/10', 'linked': 2, 'len': 711 },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addCreditCard.jsp', 'dir': '_m0/11', 'linked': 0, 'len': 2044 },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/changeEmail.jsp', 'dir': '_m0/12', 'linked': 0, 'len': 1110 },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/loginCustomer.do', 'dir': '_m0/13', 'linked': 5, 'len': 1579 },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/registerCustomer.do', 'dir': '_m0/14', 'linked': 5, 'len': 1780 },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/viewCustomer.do', 'dir': '_m0/15', 'linked': 2, 'len': 1177 } ]
  },
  { 'mime': 'image/png', 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/img/amudarya.png;jsessionid=3aaabdf69ad70d900703cadea75b', 'dir': '_m1/0', 'linked': 2, 'len': 8628 } ]
  },
  { 'mime': 'text/css', 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/css/stylesheet.css;jsessionid=3aaabdf69ad70d900703cadea75b', 'dir': '_m2/0', 'linked': 2, 'len': 888 } ]
  },
  { 'mime': 'text/html', 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activateCustomer.do', 'dir': '_m3/0', 'linked': 5, 'len': 208 } ]
  }
];

var issue_samples = [
  { 'severity': 4, 'type': 50103, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/loginCustomer.do', 'extra': 'response to \x27\x27\x27\x27\x22\x22\x22\x22 different than to \x27\x22\x27\x22\x27\x22\x27\x22', 'sid': '0', 'dir': '_i0/0' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/registerCustomer.do', 'extra': 'response to \x27\x27\x27\x27\x22\x22\x22\x22 different than to \x27\x22\x27\x22\x27\x22\x27\x22', 'sid': '0', 'dir': '_i0/1' } ]
  },
  { 'severity': 3, 'type': 40601, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/', 'extra': 'implicitly cacheable \x27Set-Cookie\x27 response', 'sid': '0', 'dir': '_i1/0' } ]
  },
  { 'severity': 3, 'type': 40305, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activateCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i2/0' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activateCustomer.do?email=.../skipfish@example.com', 'extra': '', 'sid': '0', 'dir': '_i2/1' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activationError.do', 'extra': '', 'sid': '0', 'dir': '_i2/2' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/loginCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i2/3' } ]
  },
  { 'severity': 3, 'type': 40304, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/', 'extra': '', 'sid': '0', 'dir': '_i3/0' },
    { 'url': 'http://paris.idi.ntnu.no:6280/index.html', 'extra': '', 'sid': '0', 'dir': '_i3/1' } ]
  },
  { 'severity': 3, 'type': 40101, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activateCustomer.do?email=.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000035v661204\x3e', 'extra': 'injected \x27\x3csfi...\x3e\x27 tag seen in HTML', 'sid': '0', 'dir': '_i4/0' } ]
  },
  { 'severity': 2, 'type': 30601, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activateCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i5/0' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activateCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i5/1' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addAddress.do', 'extra': '', 'sid': '0', 'dir': '_i5/2' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addCreditCard.do', 'extra': '', 'sid': '0', 'dir': '_i5/3' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/changeEmail.do', 'extra': '', 'sid': '0', 'dir': '_i5/4' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/changeName.do', 'extra': '', 'sid': '0', 'dir': '_i5/5' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/customerSupport.do', 'extra': '', 'sid': '0', 'dir': '_i5/6' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/loginCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i5/7' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/loginCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i5/8' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/loginCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i5/9' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/registerCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i5/10' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/registerCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i5/11' } ]
  },
  { 'severity': 1, 'type': 20205, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/viewCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i6/0' } ]
  },
  { 'severity': 1, 'type': 20101, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/informasjonsbehandling;jsessionid=3aaabdf69ad70d900703cadea75b/', 'extra': 'during path-based dictionary probes', 'sid': '0', 'dir': '_i7/0' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/debug/\x27\x22\x27\x22\x27\x22\x27\x22', 'extra': 'SQL injection', 'sid': '0', 'dir': '_i7/1' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/debug/list_books.jsp', 'extra': 'inject behavior', 'sid': '0', 'dir': '_i7/2' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/debug/mail_log.jsp', 'extra': 'during initial resource fetch', 'sid': '0', 'dir': '_i7/3' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activateCustomer.do', 'extra': 'during parameter brute-force tests', 'sid': '0', 'dir': '_i7/4' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/viewBook.do', 'extra': 'during initial file fetch', 'sid': '0', 'dir': '_i7/5' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/viewBook.do?isbn=9788274775268', 'extra': 'during initial file fetch', 'sid': '0', 'dir': '_i7/6' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/a.jsp', 'extra': 'during path-based dictionary probes', 'sid': '0', 'dir': '_i7/7' } ]
  },
  { 'severity': 0, 'type': 10804, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/', 'extra': '', 'sid': '0', 'dir': '_i8/0' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore//', 'extra': '', 'sid': '0', 'dir': '_i8/1' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/;jsessionid=3aaabdf69ad70d900703cadea75b/', 'extra': '', 'sid': '0', 'dir': '_i8/2' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/debug/list_books.jsp', 'extra': '', 'sid': '0', 'dir': '_i8/3' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/viewCart.do;jsessionid=3aaabdf69ad70d900703cadea75b', 'extra': '', 'sid': '0', 'dir': '_i8/4' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activateCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i8/5' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activateCustomer.do?email=9876sfi', 'extra': '', 'sid': '0', 'dir': '_i8/6' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activateCustomer.jsp', 'extra': '', 'sid': '0', 'dir': '_i8/7' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activationError.do', 'extra': '', 'sid': '0', 'dir': '_i8/8' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activationError.do;jsessionid=3aaabdf69ad70d900703cadea75b', 'extra': '', 'sid': '0', 'dir': '_i8/9' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activationError.jsp', 'extra': '', 'sid': '0', 'dir': '_i8/10' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activationSuccessful.do', 'extra': '', 'sid': '0', 'dir': '_i8/11' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addAddress.jsp', 'extra': '', 'sid': '0', 'dir': '_i8/12' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addCreditCard.jsp', 'extra': '', 'sid': '0', 'dir': '_i8/13' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/changeEmail.jsp', 'extra': '', 'sid': '0', 'dir': '_i8/14' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/changeName.jsp', 'extra': '', 'sid': '0', 'dir': '_i8/15' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/changePassword.jsp', 'extra': '', 'sid': '0', 'dir': '_i8/16' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/customerSupport.jsp', 'extra': '', 'sid': '0', 'dir': '_i8/17' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/index.jsp', 'extra': '', 'sid': '0', 'dir': '_i8/18' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/loginCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i8/19' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/loginCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i8/20' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/loginCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i8/21' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/loginCustomer.do?from=customerSupport', 'extra': '', 'sid': '0', 'dir': '_i8/22' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/loginCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i8/23' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/loginCustomer.jsp', 'extra': '', 'sid': '0', 'dir': '_i8/24' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/registerCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i8/25' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/registerCustomer.jsp', 'extra': '', 'sid': '0', 'dir': '_i8/26' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/registrationError.do', 'extra': '', 'sid': '0', 'dir': '_i8/27' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/viewCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i8/28' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/viewCustomer.jsp', 'extra': '', 'sid': '0', 'dir': '_i8/29' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/', 'extra': '', 'sid': '0', 'dir': '_i8/30' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/', 'extra': '', 'sid': '0', 'dir': '_i8/31' } ]
  },
  { 'severity': 0, 'type': 10803, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/sfi9876', 'extra': '', 'sid': '0', 'dir': '_i9/0' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/sfi9876.do', 'extra': '', 'sid': '0', 'dir': '_i9/1' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/.sf//', 'extra': '', 'sid': '0', 'dir': '_i9/2' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/sfi9876.do;jsessionid=3aaabdf69ad70d900703cadea75b/', 'extra': '', 'sid': '0', 'dir': '_i9/3' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/css/', 'extra': '', 'sid': '0', 'dir': '_i9/4' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/css/stylesheet.css/', 'extra': '', 'sid': '0', 'dir': '_i9/5' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/css/stylesheet.css;jsessionid=3aaabdf69ad70d900703cadea75b', 'extra': '', 'sid': '0', 'dir': '_i9/6' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/debug/', 'extra': '', 'sid': '0', 'dir': '_i9/7' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/img/', 'extra': '', 'sid': '0', 'dir': '_i9/8' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/img/amudarya.png/', 'extra': '', 'sid': '0', 'dir': '_i9/9' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activateCustomer.do/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000030v661204\x3e', 'extra': '', 'sid': '0', 'dir': '_i9/10' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activateCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i9/11' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activateCustomer.jsp/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000140v661204\x3e', 'extra': '', 'sid': '0', 'dir': '_i9/12' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activationError.do/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000020v661204\x3e', 'extra': '', 'sid': '0', 'dir': '_i9/13' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activationError.jsp/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000125v661204\x3e', 'extra': '', 'sid': '0', 'dir': '_i9/14' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activationSuccessful.do/--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000039v661204\x3e', 'extra': '', 'sid': '0', 'dir': '_i9/15' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addAddress.do/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000080v661204\x3e', 'extra': '', 'sid': '0', 'dir': '_i9/16' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addAddress.jsp/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000115v661204\x3e', 'extra': '', 'sid': '0', 'dir': '_i9/17' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addCreditCard.do/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000085v661204\x3e', 'extra': '', 'sid': '0', 'dir': '_i9/18' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addCreditCard.jsp/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000145v661204\x3e', 'extra': '', 'sid': '0', 'dir': '_i9/19' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/changeEmail.do/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000235v661204\x3e', 'extra': '', 'sid': '0', 'dir': '_i9/20' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/changeEmail.jsp/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000205v661204\x3e', 'extra': '', 'sid': '0', 'dir': '_i9/21' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/changeName.do/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000225v661204\x3e', 'extra': '', 'sid': '0', 'dir': '_i9/22' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/changeName.jsp/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000215v661204\x3e', 'extra': '', 'sid': '0', 'dir': '_i9/23' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/changePassword.do/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000240v661204\x3e', 'extra': '', 'sid': '0', 'dir': '_i9/24' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/changePassword.jsp/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000195v661204\x3e', 'extra': '', 'sid': '0', 'dir': '_i9/25' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/customerSupport.do/--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000254v661204\x3e', 'extra': '', 'sid': '0', 'dir': '_i9/26' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/customerSupport.jsp/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000180v661204\x3e', 'extra': '', 'sid': '0', 'dir': '_i9/27' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/index.jsp/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000110v661204\x3e', 'extra': '', 'sid': '0', 'dir': '_i9/28' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/loginCustomer.do/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000070v661204\x3e', 'extra': '', 'sid': '0', 'dir': '_i9/29' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/loginCustomer.jsp/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000130v661204\x3e', 'extra': '', 'sid': '0', 'dir': '_i9/30' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/registerCustomer.do/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000045v661204\x3e', 'extra': '', 'sid': '0', 'dir': '_i9/31' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/registerCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i9/32' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/registerCustomer.jsp/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000135v661204\x3e', 'extra': '', 'sid': '0', 'dir': '_i9/33' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/registrationError.do/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000050v661204\x3e', 'extra': '', 'sid': '0', 'dir': '_i9/34' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/viewCustomer.do/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000075v661204\x3e', 'extra': '', 'sid': '0', 'dir': '_i9/35' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/viewCustomer.jsp/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000200v661204\x3e', 'extra': '', 'sid': '0', 'dir': '_i9/36' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/sfi9876.do', 'extra': '', 'sid': '0', 'dir': '_i9/37' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/sfi9876.do', 'extra': '', 'sid': '0', 'dir': '_i9/38' },
    { 'url': 'http://paris.idi.ntnu.no:6280/docs/', 'extra': '', 'sid': '0', 'dir': '_i9/39' },
    { 'url': 'http://paris.idi.ntnu.no:6280/index.html/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000005v661204\x3e', 'extra': '', 'sid': '0', 'dir': '_i9/40' } ]
  },
  { 'severity': 0, 'type': 10602, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/changePassword.do', 'extra': '', 'sid': '0', 'dir': '_i10/0' } ]
  },
  { 'severity': 0, 'type': 10505, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activateCustomer.do', 'extra': 'activationToken', 'sid': '0', 'dir': '_i11/0' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addAddress.jsp', 'extra': 'address', 'sid': '0', 'dir': '_i11/1' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/customerSupport.jsp', 'extra': 'department', 'sid': '0', 'dir': '_i11/2' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/customerSupport.jsp', 'extra': 'content', 'sid': '0', 'dir': '_i11/3' } ]
  },
  { 'severity': 0, 'type': 10405, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activateCustomer.jsp', 'extra': '', 'sid': '0', 'dir': '_i12/0' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activationError.do;jsessionid=3aaabdf69ad70d900703cadea75b', 'extra': '', 'sid': '0', 'dir': '_i12/1' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activationError.jsp', 'extra': '', 'sid': '0', 'dir': '_i12/2' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addAddress.do;jsessionid=3aaabdf69ad70d900703cadea75b', 'extra': '', 'sid': '0', 'dir': '_i12/3' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addAddress.jsp', 'extra': '', 'sid': '0', 'dir': '_i12/4' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addCreditCard.jsp', 'extra': '', 'sid': '0', 'dir': '_i12/5' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/changeEmail.jsp', 'extra': '', 'sid': '0', 'dir': '_i12/6' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/changeName.jsp', 'extra': '', 'sid': '0', 'dir': '_i12/7' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/changePassword.jsp', 'extra': '', 'sid': '0', 'dir': '_i12/8' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/customerSupport.jsp', 'extra': '', 'sid': '0', 'dir': '_i12/9' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/index.jsp', 'extra': '', 'sid': '0', 'dir': '_i12/10' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/loginCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i12/11' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/loginCustomer.jsp', 'extra': '', 'sid': '0', 'dir': '_i12/12' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/registerCustomer.jsp', 'extra': '', 'sid': '0', 'dir': '_i12/13' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/viewCustomer.jsp', 'extra': '', 'sid': '0', 'dir': '_i12/14' },
    { 'url': 'http://paris.idi.ntnu.no:6280/index.html', 'extra': '', 'sid': '0', 'dir': '_i12/15' } ]
  },
  { 'severity': 0, 'type': 10403, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/sfi9876.do', 'extra': '', 'sid': '0', 'dir': '_i13/0' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/sfi9876.do;jsessionid=3aaabdf69ad70d900703cadea75b/', 'extra': '', 'sid': '0', 'dir': '_i13/1' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activateCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i13/2' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/registerCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i13/3' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/sfi9876.do', 'extra': '', 'sid': '0', 'dir': '_i13/4' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/sfi9876.do', 'extra': '', 'sid': '0', 'dir': '_i13/5' } ]
  },
  { 'severity': 0, 'type': 10205, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/sfi9876', 'extra': '', 'sid': '0', 'dir': '_i14/0' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/sfi9876.do', 'extra': '', 'sid': '0', 'dir': '_i14/1' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/sfi9876.do;jsessionid=3aaabdf69ad70d900703cadea75b/', 'extra': '', 'sid': '0', 'dir': '_i14/2' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/sfi9876.do', 'extra': '', 'sid': '0', 'dir': '_i14/3' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/sfi9876.do', 'extra': '', 'sid': '0', 'dir': '_i14/4' } ]
  },
  { 'severity': 0, 'type': 10204, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/', 'extra': 'X-Powered-By', 'sid': '0', 'dir': '_i15/0' } ]
  },
  { 'severity': 0, 'type': 10202, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/', 'extra': 'GlassFish Server Open Source Edition  4.0 ', 'sid': '0', 'dir': '_i16/0' } ]
  },
  { 'severity': 0, 'type': 10201, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/', 'extra': 'JSESSIONID', 'sid': '0', 'dir': '_i17/0' } ]
  }
];

