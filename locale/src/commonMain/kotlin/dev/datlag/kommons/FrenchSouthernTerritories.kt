package dev.datlag.kommons


data object FrenchSouthernTerritories : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("TF")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("ATF")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(260)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(262)
}