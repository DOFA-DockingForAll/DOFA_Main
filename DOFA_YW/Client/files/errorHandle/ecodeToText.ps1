
switch ( $p.ExitCode )
{
    0 { $result = 'Action completed successfully.'    }
    13 { $result = 'The data is invalid.'  }
    87 { $result = 'One of the parameters was invalid.'   }
    120 { $result = 'This function is not available for this platform. It is only available on Windows 2000 and Windows XP with Window Installer version 2.0.' }
    1259 { $result = 'You are using Windows Installer version 2.0 and Windows XP or later.'  }
    1601 { $result = 'The Windows Installer service could not be accessed. Contact your support personnel to verify that the Windows Installer service is properly registered.'    }
    1602 { $result = 'User cancel installation.'  }
    1603 { $result = 'Fatal error during installation.'  }
    1604 { $result = 'Installation suspended, incomplete.'  }
    1605 { $result = 'This action is only valid for products that are currently installed.'  }
    1606 { $result = 'Feature ID not registered.'  }
    1607 { $result = 'Component ID not registered.'  }
    1608 { $result = 'Unknown property.'  }
    1609 { $result = 'Handle is in an invalid state.'  }
    1610 { $result = 'The configuration data for this product is corrupt. Contact your support personnel.'  }
    1611 { $result = 'Component qualifier not present.'  }
    1612 { $result = 'The installation source for this product is not available. Verify that the source exists and that you can access it.'  }
    1613 { $result = 'This installation package cannot be installed by the Windows Installer service. You must install a Windows service pack that contains a newer version of the Windows Installer service.'  }
    1614 { $result = 'Product is uninstalled.'  }
    1615 { $result = 'SQL query syntax invalid or unsupported.'  }
    1616 { $result = 'Record field does not exist.'  }
    1618 { $result = 'Another installation is already in progress. Complete that installation before proceeding with this install.'  }
    1619 { $result = 'This installation package could not be opened. Verify that the package exists and that you can access it, or contact the application vendor to verify that this is a valid Windows Installer package.'  }
    1620 { $result = 'This installation package could not be opened. Contact the application vendor to verify that this is a valid Windows Installer package.'  }
    1621 { $result = 'There was an error starting the Windows Installer service user interface. Contact your support personnel.'  }
    1622 { $result = 'Error opening installation log file. Verify that the specified log file location exists and is writable.'  }
    1623 { $result = 'This language of this installation package is not supported by your system.'  }
    1624 { $result = 'Error applying transforms. Verify that the specified transform paths are valid.'  }
    1625 { $result = 'This installation is forbidden by system policy. Contact your system administrator.'  }
    1626 { $result = 'Function could not be executed.'  }
    1627 { $result = 'Function failed during execution.'  }
    1628 { $result = 'Invalid or unknown table specified.'  }
    1629 { $result = 'Data supplied is of wrong type.'  }
    1630 { $result = 'Data of this type is not supported.'  }
    1631 { $result = 'The Windows Installer service failed to start. Contact your support personnel.'  }
    1632 { $result = 'The temp folder is either full or inaccessible. Verify that the temp folder exists and that you can write to it.'  }
    1633 { $result = 'This installation package is not supported on this platform. Contact your application vendor.'  }
    1634 { $result = 'Component not used on this machine'  }
    1635 { $result = 'This patch package could not be opened. Verify that the patch package exists and that you can access it, or contact the application vendor to verify that this is a valid Windows Installer patch package.'  }
    1636 { $result = 'This patch package could not be opened. Contact the application vendor to verify that this is a valid Windows Installer patch package.'  }
    1637 { $result = 'This patch package cannot be processed by the Windows Installer service. You must install a Windows service pack that contains a newer version of the Windows Installer service.'  }
    1638 { $result = 'Another version of this product is already installed. Installation of this version cannot continue. To configure or remove the existing version of this product, use Add/Remove Programs on the Control Panel.'  }
    1639 { $result = 'Invalid command line argument. Consult the Windows Installer SDK for detailed command line help.'  }
    1640 { $result = 'Installation from a Terminal Server client session not permitted for current user.'  }
    1641 { $result = 'The installer has started a reboot. This error code not available on Windows Installer version 1.0.'  }
    1642 { $result = 'The installer cannot install the upgrade patch because the program being upgraded may be missing or the upgrade patch updates a different version of the program.'  }
    1643 { $result = 'The patch package is not permitted by system policy. This error code is available with Windows Installer versions 2.0 or later.'  }
    1644 { $result = 'One or more customizations are not permitted by system policy. This error code is available with Windows Installer versions 2.0 or later.'  }
    3010 { $result = 'A reboot is required to complete the install. This does not include installs where the ForceReboot action is run. This error code not available on Windows Installer version 1.0.'  }
    default { $result = 'invalid error code'  }
}

$result