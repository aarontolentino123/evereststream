# EverestStream - Custom Android Auto Video & Web Portal

Complete Android Studio & GitHub Actions project for streaming YouTube and web content from a Samsung Galaxy S26 Ultra to a Ford Everest (SYNC 4 / 4A).

## How to Build the APK (No PC Setup Required)
1. Create a new repository on [GitHub](https://github.com/new).
2. Extract this ZIP and upload all files (including the `.github` folder) to your repository.
3. Go to the **Actions** tab in your GitHub repository.
4. Click on the **Build EverestStream APK** workflow run and download `EverestStream-APK` under the **Artifacts** section once the build finishes.

## How to Install on Samsung Galaxy S26 Ultra
1. Enable **Developer Mode** in Android Auto settings (tap *Version* 10 times) and check **Unknown Sources**.
2. Install the compiled `app-debug.apk` using **KingInstaller** (with Shizuku) or via ADB from a computer:
   ```bash
   adb install -r -i "com.android.vending" app-debug.apk
   ```
