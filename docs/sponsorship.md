# Sponsorship & Access

**Native-Kommons** is not a typical open-source library. It's a highly complex, niche project dedicated to solving the most difficult low-level and native KMP problems. 
To dedicate the significant time and resources required to maintain and expand the "utility belt", especially with it's commitment to **all** KMP targets, we've made it a sponsor-only project.  
This model allows us to focus entirely on quality and tackle unique, high-value problems, that standard libraries don't address.

## Become a sponsor

Sponsoring is managed directly through GitHub Sponsors or Polar.  
Choose a tier that works for you to gain access to the private repository and our package registry.

[:simple-githubsponsors: GitHub Sponsors](https://github.com/sponsors/DatL4g/){ .md-button .md-button--primary }
[Polar](https://polar.sh/DatL4g){ .md-button }

## Get Access

Step-by-step guide to access the repository and package registry.

### Sponsor the project

Choose your preferred sponsor platform, click on the 'Sponsor' buttons above and complete the process on GitHub or Polar.  
You will need a GitHub account.

### Receive Repository Access

Once your sponsorship is active, you will automatically receive access to the private GitHub repository.  
This process may take some time depending on the sponsoring platform.

### Configure Gradle / Maven Access

After you are granted repository access, you will need to configure the package registry.

```kotlin
maven {
    url = uri("https://maven.pkg.github.com/DatL4g/Native-Kommons")
    credentials {
        username = project.findProperty("gpr.user") as? String ?: System.getenv("USERNAME")
        password = project.findProperty("gpr.key") as? String ?: System.getenv("TOKEN")
    }
}
```

Read the full documentation here: [GitHub Docs](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-gradle-registry#using-a-published-package)

### Start Building!

You're all set.  
You can now begin adding modules to your projects.

**Welcome aboard!**
