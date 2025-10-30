package dev.datlag.kommons


data object Bolivia : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("BO")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("BOL")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(68)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(591)
}