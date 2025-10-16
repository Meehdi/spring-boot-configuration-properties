# Spring Boot @ConfigurationProperties Tutorial

A simple demonstration of Spring Boot's `@ConfigurationProperties` pattern - transforming scattered `@Value` annotations into clean, type-safe configuration classes.

## 📖 Article

Read the complete tutorial on Medium: **[From @Value Chaos to @ConfigurationProperties Clarity](https://medium.com/@elmehdi.kzadri_97626/from-value-chaos-to-configurationproperties-clarity-a-spring-boot-guide-7099c011d8db)** *(add your Medium article link here)*

## 🎯 What This Shows

A minimal example with:
- **EmailProperties** - Type-safe configuration class
- **EmailService** - Service using the configuration
- **EmailController** - REST endpoint to test it

That's it. Simple and clear.

## 🏃 Running
```bash
./gradlew bootRun
```

## 🧪 Testing
```bash
# Send a test email
curl -X POST http://localhost:8080/api/email/send \
  -H "Content-Type: application/json" \
  -d '{"to":"user@example.com","subject":"Test","body":"Hello"}'
```

**Response:**
```
Email sent!
From: noreply@myapp.com
To: user@example.com
Subject: Test
SMTP: smtp.gmail.com:587
```

## 💡 Key Point

Instead of this:
```java
@Value("${email.smtp.host}")
private String smtpHost;
```

You get this:
```java
emailProperties.getSmtp().getHost()
```

Type-safe, validated, and testable. See the [Medium article](https://medium.com/@elmehdi.kzadri_97626/from-value-chaos-to-configurationproperties-clarity-a-spring-boot-guide-7099c011d8db) for details.

---

**Author:** Meehdi