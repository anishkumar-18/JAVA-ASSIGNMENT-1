$ErrorActionPreference = "Stop"

$files = Get-ChildItem -Path $PSScriptRoot -Recurse -Filter Main.java

foreach ($file in $files) {
    $dir = $file.Directory.FullName
    Write-Host ""
    Write-Host "========================================" -ForegroundColor Cyan
    Write-Host $dir -ForegroundColor Yellow
    Write-Host "========================================" -ForegroundColor Cyan

    Push-Location $dir
    try {
        javac Main.java
        if ($LASTEXITCODE -ne 0) {
            throw "Compilation failed in $dir"
        }

        # Programs that require stdin are compile-checked here.
        # Class-style programs are run directly; input-driven programs can be run
        # manually with the sample input in their source document.
        if ($file.FullName -notmatch "Week8") {
            java Main
        } else {
            Write-Host "Compiled successfully. Run this input-driven Week 8 program manually with its sample input."
        }
    }
    finally {
        Pop-Location
    }
}
