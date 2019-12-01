# Urban.Tech Moscow — VTB Cifra
## Mobile Application Security Testing — [SEQ.SCIENCE](https://seq.science/)

**Team:**
1. Nils Putnins, Captain, Security Research
2. Einars Anspoks, Communication
3. Alisher Urunov, Security Research

**Resources:**
- https://play.google.com/store/apps/details?id=com.touchin.vtb
- https://apps.apple.com/us/app/cifra/id1460672861
- https://cifra.app/
- https://cifra.pw/

**Roadmap:**

Sunday, October 29, 2019:
1. Communication with the client, basic information gathering.
2. Decompilation of the APK (*1.4.546*) and static analysis.

Saturday, 30 November, 2019:
1. Gathering OSINT information.
2. In-depth application analysis.

Sunday, 01 December, 2019:
1. Initialisation of the repository.
2. Discovering the services. SSH: "authmethod_is_enabled password".
3. Creating an example dump of applications connection between application and API (*connection.example*).

**Android:**
- Using JWT authentication tokens (android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21).
- SHA1 usage.
- androidx.appcompat.app.AppCompatViewInflater potential vulnerability (line 82).
  - Related to TwilightManager.
- androidx.appcompat.app.J IP address retrieval.
- api.cifra.pw (*95.213.182.234*)

**iPhone:**
- Retrieval of *certificate.der*, GlobalSign RSA DV SSL CA 20180.

**Network Discovery:**
```
PORT    STATE    SERVICE      VERSION
22/tcp  open     ssh          OpenSSH 7.4p1 Debian 10+deb9u6 (protocol 2.0)
80/tcp  open     http         Golang net/http server (Go-IPFS json-rpc or InfluxDB API)
135/tcp filtered msrpc
139/tcp filtered netbios-ssn
443/tcp open     ssl/http     Golang net/http server (Go-IPFS json-rpc or InfluxDB API)
445/tcp filtered microsoft-ds
Service Info: OS: Linux; CPE: cpe:/o:linux:linux_kernel
```

**OSINT:**
- iOS: ANGRY DEVELOPERS S.R.L. / Parasca Kirill (*k.paraska@modulbank.ru*), Parasca Mihail
- https://appfollow.io/ios/cifra/1460672861
- https://appadvice.com/app/cifra/1460672861
- cifrateam@gmail.com
- https://tilda.cc/ -> cifra.app
- https://apkdl.in/app/details?id=com.touchin.vtb
- https://www.linkedin.com/in/alexeevandrei/