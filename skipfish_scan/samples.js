var mime_samples = [
  { 'mime': 'application/xhtml+xml', 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/', 'dir': '_m0/0', 'linked': 2, 'len': 4626 },
    { 'url': 'http://paris.idi.ntnu.no:6280/sfi9876', 'dir': '_m0/1', 'linked': 2, 'len': 1082 },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activateCustomer.do', 'dir': '_m0/2', 'linked': 2, 'len': 1272 },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/customerSupport.jsp', 'dir': '_m0/3', 'linked': 2, 'len': 1437 },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addAddress.jsp', 'dir': '_m0/4', 'linked': 2, 'len': 846 },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/', 'dir': '_m0/5', 'linked': 5, 'len': 1228 },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/sfi9876.do', 'dir': '_m0/6', 'linked': 5, 'len': 1468 },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/debug/list_books.jsp', 'dir': '_m0/7', 'linked': 2, 'len': 189252 },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/debug/mail_log.jsp', 'dir': '_m0/8', 'linked': 2, 'len': 405039 },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addCreditCard.do', 'dir': '_m0/9', 'linked': 5, 'len': 2838 },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addCreditCard.jsp', 'dir': '_m0/10', 'linked': 0, 'len': 2044 },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/changeEmail.jsp', 'dir': '_m0/11', 'linked': 0, 'len': 1110 },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/loginCustomer.do', 'dir': '_m0/12', 'linked': 5, 'len': 1579 },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/loginCustomer.do', 'dir': '_m0/13', 'linked': 5, 'len': 640 },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/registerCustomer.do', 'dir': '_m0/14', 'linked': 5, 'len': 1780 },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/viewCustomer.jsp', 'dir': '_m0/15', 'linked': 0, 'len': 1173 } ]
  },
  { 'mime': 'image/png', 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/img/amudarya.png', 'dir': '_m1/0', 'linked': 2, 'len': 8628 } ]
  },
  { 'mime': 'text/css', 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/css/stylesheet.css', 'dir': '_m2/0', 'linked': 2, 'len': 888 } ]
  },
  { 'mime': 'text/html', 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addAddress.do', 'dir': '_m3/0', 'linked': 5, 'len': 222 } ]
  }
];

var issue_samples = [
  { 'severity': 4, 'type': 50103, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/loginCustomer.do', 'extra': 'response to \x27\x27\x27\x27\x22\x22\x22\x22 different than to \x27\x22\x27\x22\x27\x22\x27\x22', 'sid': '0', 'dir': '_i0/0' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/registerCustomer.do', 'extra': 'response to \x27\x27\x27\x27\x22\x22\x22\x22 different than to \x27\x22\x27\x22\x27\x22\x27\x22', 'sid': '0', 'dir': '_i0/1' } ]
  },
  { 'severity': 4, 'type': 50102, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addCreditCard.do?from=viewCustomer`false`', 'extra': 'responses to `true` and `false` different than to `uname`', 'sid': '0', 'dir': '_i1/0' } ]
  },
  { 'severity': 3, 'type': 40601, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/', 'extra': 'implicitly cacheable \x27Set-Cookie\x27 response', 'sid': '0', 'dir': '_i2/0' } ]
  },
  { 'severity': 3, 'type': 40305, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/debug/mail_log.jsp', 'extra': '', 'sid': '0', 'dir': '_i3/0' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activateCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i3/1' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activateCustomer.do?email=.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000045v602311\x3e', 'extra': '', 'sid': '0', 'dir': '_i3/2' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/loginCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i3/3' } ]
  },
  { 'severity': 3, 'type': 40304, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/', 'extra': '', 'sid': '0', 'dir': '_i4/0' },
    { 'url': 'http://paris.idi.ntnu.no:6280//', 'extra': '', 'sid': '0', 'dir': '_i4/1' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addCreditCard.do', 'extra': '', 'sid': '0', 'dir': '_i4/2' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addCreditCard.do', 'extra': '', 'sid': '0', 'dir': '_i4/3' } ]
  },
  { 'severity': 3, 'type': 40101, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activateCustomer.do?email=.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000045v602311\x3e', 'extra': 'injected \x27\x3csfi...\x3e\x27 tag seen in HTML', 'sid': '0', 'dir': '_i5/0' } ]
  },
  { 'severity': 2, 'type': 30909, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/debug/mail_log.jsp', 'extra': 'ASP source', 'sid': '32006', 'dir': '_i6/0' } ]
  },
  { 'severity': 2, 'type': 30601, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activateCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i7/0' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activateCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i7/1' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addAddress.do', 'extra': '', 'sid': '0', 'dir': '_i7/2' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addCreditCard.do', 'extra': '', 'sid': '0', 'dir': '_i7/3' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addCreditCard.do', 'extra': '', 'sid': '0', 'dir': '_i7/4' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addCreditCard.do', 'extra': '', 'sid': '0', 'dir': '_i7/5' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addCreditCard.do', 'extra': '', 'sid': '0', 'dir': '_i7/6' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addCreditCard.do', 'extra': '', 'sid': '0', 'dir': '_i7/7' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/changeEmail.do', 'extra': '', 'sid': '0', 'dir': '_i7/8' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/customerSupport.do', 'extra': '', 'sid': '0', 'dir': '_i7/9' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/customerSupport.do', 'extra': '', 'sid': '0', 'dir': '_i7/10' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/loginCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i7/11' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/loginCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i7/12' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/loginCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i7/13' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/registerCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i7/14' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/registerCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i7/15' } ]
  },
  { 'severity': 1, 'type': 20205, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/customerSupport.do', 'extra': '', 'sid': '0', 'dir': '_i8/0' } ]
  },
  { 'severity': 1, 'type': 20101, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/263FE92196A7B174.png', 'extra': 'during path-based dictionary probes', 'sid': '0', 'dir': '_i9/0' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/debug/list_books.jsp', 'extra': 'inject behavior', 'sid': '0', 'dir': '_i9/1' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/debug/mail_log.jsp', 'extra': 'inject behavior', 'sid': '0', 'dir': '_i9/2' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/debug/test.com', 'extra': 'during initial resource fetch', 'sid': '0', 'dir': '_i9/3' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/img/amudarya.png/`sleep%24{IFS}5`', 'extra': 'Shell injection (spec)', 'sid': '0', 'dir': '_i9/4' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activateCustomer.do', 'extra': 'during try list fetches', 'sid': '0', 'dir': '_i9/5' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activateCustomer.do?email=cause', 'extra': 'during try list fetches', 'sid': '0', 'dir': '_i9/6' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/loginCustomer.do', 'extra': 'during parameter brute-force tests', 'sid': '0', 'dir': '_i9/7' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/viewBook.do', 'extra': 'during initial file fetch', 'sid': '0', 'dir': '_i9/8' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/viewBook.do?isbn=9788274775268', 'extra': 'during initial file fetch', 'sid': '0', 'dir': '_i9/9' } ]
  },
  { 'severity': 0, 'type': 10804, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/', 'extra': '', 'sid': '0', 'dir': '_i10/0' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore//', 'extra': '', 'sid': '0', 'dir': '_i10/1' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/debug/list_books.jsp', 'extra': '', 'sid': '0', 'dir': '_i10/2' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activateCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i10/3' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activateCustomer.do?email=9876sfi', 'extra': '', 'sid': '0', 'dir': '_i10/4' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activateCustomer.jsp', 'extra': '', 'sid': '0', 'dir': '_i10/5' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addAddress.jsp', 'extra': '', 'sid': '0', 'dir': '_i10/6' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addCreditCard.do', 'extra': '', 'sid': '0', 'dir': '_i10/7' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addCreditCard.do', 'extra': '', 'sid': '0', 'dir': '_i10/8' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addCreditCard.do', 'extra': '', 'sid': '0', 'dir': '_i10/9' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addCreditCard.do?from=viewCustomer`true`', 'extra': '', 'sid': '0', 'dir': '_i10/10' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addCreditCard.do?from=Activate', 'extra': '', 'sid': '0', 'dir': '_i10/11' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addCreditCard.jsp', 'extra': '', 'sid': '0', 'dir': '_i10/12' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/changeEmail.jsp', 'extra': '', 'sid': '0', 'dir': '_i10/13' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/changePassword.jsp', 'extra': '', 'sid': '0', 'dir': '_i10/14' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/customerSupport.do', 'extra': '', 'sid': '0', 'dir': '_i10/15' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/customerSupport.jsp', 'extra': '', 'sid': '0', 'dir': '_i10/16' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/index.jsp', 'extra': '', 'sid': '0', 'dir': '_i10/17' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/loginCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i10/18' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/loginCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i10/19' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/loginCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i10/20' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/loginCustomer.do?from=viewCustomer', 'extra': '', 'sid': '0', 'dir': '_i10/21' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/loginCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i10/22' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/loginCustomer.jsp', 'extra': '', 'sid': '0', 'dir': '_i10/23' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/registerCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i10/24' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/registerCustomer.jsp', 'extra': '', 'sid': '0', 'dir': '_i10/25' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/registrationError.jsp', 'extra': '', 'sid': '0', 'dir': '_i10/26' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/viewCustomer.jsp', 'extra': '', 'sid': '0', 'dir': '_i10/27' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/', 'extra': '', 'sid': '0', 'dir': '_i10/28' } ]
  },
  { 'severity': 0, 'type': 10803, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/sfi9876', 'extra': '', 'sid': '0', 'dir': '_i11/0' },
    { 'url': 'http://paris.idi.ntnu.no:6280/.sf//', 'extra': '', 'sid': '0', 'dir': '_i11/1' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/sfi9876.do', 'extra': '', 'sid': '0', 'dir': '_i11/2' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/.sf//', 'extra': '', 'sid': '0', 'dir': '_i11/3' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/css/', 'extra': '', 'sid': '0', 'dir': '_i11/4' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/css/stylesheet.css', 'extra': '', 'sid': '0', 'dir': '_i11/5' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/debug/', 'extra': '', 'sid': '0', 'dir': '_i11/6' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/img/', 'extra': '', 'sid': '0', 'dir': '_i11/7' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/img/amudarya.png/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000265v602311\x3e', 'extra': '', 'sid': '0', 'dir': '_i11/8' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activateCustomer.do/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000035v602311\x3e', 'extra': '', 'sid': '0', 'dir': '_i11/9' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activateCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i11/10' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activateCustomer.jsp/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000070v602311\x3e', 'extra': '', 'sid': '0', 'dir': '_i11/11' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addAddress.do/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000110v602311\x3e', 'extra': '', 'sid': '0', 'dir': '_i11/12' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addAddress.jsp/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000195v602311\x3e', 'extra': '', 'sid': '0', 'dir': '_i11/13' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addCreditCard.do/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000120v602311\x3e', 'extra': '', 'sid': '0', 'dir': '_i11/14' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addCreditCard.do', 'extra': '', 'sid': '0', 'dir': '_i11/15' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addCreditCard.do', 'extra': '', 'sid': '0', 'dir': '_i11/16' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addCreditCard.jsp/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000200v602311\x3e', 'extra': '', 'sid': '0', 'dir': '_i11/17' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/changeEmail.do/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000100v602311\x3e', 'extra': '', 'sid': '0', 'dir': '_i11/18' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/changeEmail.jsp/--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000214v602311\x3e', 'extra': '', 'sid': '0', 'dir': '_i11/19' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/changeName.do/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000130v602311\x3e', 'extra': '', 'sid': '0', 'dir': '_i11/20' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/changePassword.do/--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000104v602311\x3e', 'extra': '', 'sid': '0', 'dir': '_i11/21' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/changePassword.jsp/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000210v602311\x3e', 'extra': '', 'sid': '0', 'dir': '_i11/22' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/customerSupport.do/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000240v602311\x3e', 'extra': '', 'sid': '0', 'dir': '_i11/23' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/customerSupport.jsp/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000090v602311\x3e', 'extra': '', 'sid': '0', 'dir': '_i11/24' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/index.jsp/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000050v602311\x3e', 'extra': '', 'sid': '0', 'dir': '_i11/25' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/loginCustomer.do/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000150v602311\x3e', 'extra': '', 'sid': '0', 'dir': '_i11/26' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/loginCustomer.jsp/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000065v602311\x3e', 'extra': '', 'sid': '0', 'dir': '_i11/27' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/registerCustomer.do/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000010v602311\x3e', 'extra': '', 'sid': '0', 'dir': '_i11/28' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/registerCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i11/29' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/registerCustomer.jsp/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000060v602311\x3e', 'extra': '', 'sid': '0', 'dir': '_i11/30' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/registrationError.jsp/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000055v602311\x3e', 'extra': '', 'sid': '0', 'dir': '_i11/31' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/viewCustomer.do/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000005v602311\x3e', 'extra': '', 'sid': '0', 'dir': '_i11/32' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/viewCustomer.jsp/.htaccess.aspx--\x3e\x22\x3e\x27\x3e\x27\x22\x3csfi000125v602311\x3e', 'extra': '', 'sid': '0', 'dir': '_i11/33' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/sfi9876.do', 'extra': '', 'sid': '0', 'dir': '_i11/34' },
    { 'url': 'http://paris.idi.ntnu.no:6280/docs/', 'extra': '', 'sid': '0', 'dir': '_i11/35' } ]
  },
  { 'severity': 0, 'type': 10602, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/changePassword.do', 'extra': '', 'sid': '0', 'dir': '_i12/0' } ]
  },
  { 'severity': 0, 'type': 10505, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activateCustomer.do', 'extra': 'activationToken', 'sid': '0', 'dir': '_i13/0' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/customerSupport.jsp', 'extra': 'department', 'sid': '0', 'dir': '_i13/1' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/customerSupport.jsp', 'extra': 'content', 'sid': '0', 'dir': '_i13/2' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addAddress.jsp', 'extra': 'address', 'sid': '0', 'dir': '_i13/3' } ]
  },
  { 'severity': 0, 'type': 10405, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280//', 'extra': '', 'sid': '0', 'dir': '_i14/0' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore//', 'extra': '', 'sid': '0', 'dir': '_i14/1' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activateCustomer.jsp', 'extra': '', 'sid': '0', 'dir': '_i14/2' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addAddress.jsp', 'extra': '', 'sid': '0', 'dir': '_i14/3' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addCreditCard.do', 'extra': '', 'sid': '0', 'dir': '_i14/4' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addCreditCard.do?from=Activate', 'extra': '', 'sid': '0', 'dir': '_i14/5' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addCreditCard.jsp', 'extra': '', 'sid': '0', 'dir': '_i14/6' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/changeEmail.jsp', 'extra': '', 'sid': '0', 'dir': '_i14/7' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/changePassword.jsp', 'extra': '', 'sid': '0', 'dir': '_i14/8' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/customerSupport.jsp', 'extra': '', 'sid': '0', 'dir': '_i14/9' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/index.jsp', 'extra': '', 'sid': '0', 'dir': '_i14/10' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/loginCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i14/11' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/loginCustomer.jsp', 'extra': '', 'sid': '0', 'dir': '_i14/12' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/registerCustomer.jsp', 'extra': '', 'sid': '0', 'dir': '_i14/13' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/registrationError.jsp', 'extra': '', 'sid': '0', 'dir': '_i14/14' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/viewCustomer.jsp', 'extra': '', 'sid': '0', 'dir': '_i14/15' } ]
  },
  { 'severity': 0, 'type': 10403, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/sfi9876.do', 'extra': '', 'sid': '0', 'dir': '_i15/0' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/activateCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i15/1' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addCreditCard.do', 'extra': '', 'sid': '0', 'dir': '_i15/2' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/addCreditCard.do', 'extra': '', 'sid': '0', 'dir': '_i15/3' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/registerCustomer.do', 'extra': '', 'sid': '0', 'dir': '_i15/4' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/sfi9876.do', 'extra': '', 'sid': '0', 'dir': '_i15/5' } ]
  },
  { 'severity': 0, 'type': 10205, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/sfi9876', 'extra': '', 'sid': '0', 'dir': '_i16/0' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/sfi9876.do', 'extra': '', 'sid': '0', 'dir': '_i16/1' },
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/sfi9876.do', 'extra': '', 'sid': '0', 'dir': '_i16/2' } ]
  },
  { 'severity': 0, 'type': 10204, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/', 'extra': 'X-Powered-By', 'sid': '0', 'dir': '_i17/0' } ]
  },
  { 'severity': 0, 'type': 10202, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/', 'extra': 'GlassFish Server Open Source Edition  4.0 ', 'sid': '0', 'dir': '_i18/0' } ]
  },
  { 'severity': 0, 'type': 10201, 'samples': [
    { 'url': 'http://paris.idi.ntnu.no:6280/bookstore/', 'extra': 'JSESSIONID', 'sid': '0', 'dir': '_i19/0' } ]
  }
];

